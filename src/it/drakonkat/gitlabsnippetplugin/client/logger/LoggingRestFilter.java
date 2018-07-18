/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.client.logger;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Priority(Integer.MIN_VALUE)
@Provider
public class LoggingRestFilter implements ClientRequestFilter, ClientResponseFilter, WriterInterceptor {

        private static final Logger logger = Logger.getLogger(LoggingRestFilter.class.getName());
        private static final String ENTITY_STREAM_PROPERTY = "LoggingRestFilter.entityStream";
        private static final String URI_PROPERTY = "LoggingRestFilter.uri";
        private static final String HTTP_METHOD = "LoggingRestFilter.httpMethod";

        private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

        private final int maxEntitySize = 1024 * 8;

        private void log(String uri, StringBuilder sb) {
                logger.info("[" + uri + "] " + sb.toString());
        }

        private InputStream logInboundEntity(final StringBuilder b, InputStream stream, final Charset charset) throws IOException {
                if (!stream.markSupported()) {
                        stream = new BufferedInputStream(stream);
                }
                stream.mark(maxEntitySize + 1);
                final byte[] entity = new byte[maxEntitySize + 1];
                final int entitySize = stream.read(entity);
                b.append(new String(entity, 0, Math.min(entitySize, maxEntitySize), charset));
                if (entitySize > maxEntitySize) {
                        b.append("...more...");
                }

                stream.reset();
                return stream;
        }

        @Override
        public void filter(ClientRequestContext requestContext) throws IOException {
                if (requestContext.hasEntity()) {
                        final OutputStream stream = new LoggingStream(requestContext.getEntityStream());
                        requestContext.setEntityStream(stream);
                        requestContext.setProperty(ENTITY_STREAM_PROPERTY, stream);
                        String uri = requestContext.getUri().toString();
                        String httpMethod = requestContext.getMethod();
                        requestContext.setProperty(URI_PROPERTY, uri);
                        requestContext.setProperty(HTTP_METHOD, httpMethod);
                }
        }

        @Override
        public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
                final StringBuilder sb = new StringBuilder();
                if (responseContext.hasEntity()) {
                        responseContext.setEntityStream(logInboundEntity(sb, responseContext.getEntityStream(), DEFAULT_CHARSET));
                        URI uri = requestContext.getUri();
                        String httpMethod = requestContext.getMethod();
                        log(httpMethod + " " + uri.toString(), sb);
                }

        }

        @Override
        public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
                final LoggingStream stream = (LoggingStream) context.getProperty(ENTITY_STREAM_PROPERTY);
                final String uri = (String) context.getProperty(URI_PROPERTY);
                final String httpMethod = (String) context.getProperty(HTTP_METHOD);
                context.proceed();
                if (stream != null) {
                        log(httpMethod + " " + uri, stream.getStringBuilder(DEFAULT_CHARSET));
                }
        }

        private class LoggingStream extends FilterOutputStream {

                private final StringBuilder sb = new StringBuilder();
                private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

                LoggingStream(OutputStream out) {
                        super(out);
                }

                StringBuilder getStringBuilder(Charset charset) {
                        // write entity to the builder
                        final byte[] entity = baos.toByteArray();

                        sb.append(new String(entity, 0, entity.length, charset));
                        if (entity.length > maxEntitySize) {
                                sb.append("...more...");
                        }
                        return sb;
                }

                @Override
                public void write(final int i) throws IOException {
                        if (baos.size() <= maxEntitySize) {
                                baos.write(i);
                        }
                        out.write(i);
                }
        }
}
