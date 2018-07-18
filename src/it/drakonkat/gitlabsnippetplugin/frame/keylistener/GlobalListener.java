/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.frame.keylistener;

import it.drakonkat.gitlabsnippetplugin.client.model.GitlabModel;
import it.drakonkat.gitlabsnippetplugin.client.model.GitlabVisibility;
import it.drakonkat.gitlabsnippetplugin.frame.MainFrame;
import it.drakonkat.gitlabsnippetplugin.frame.SnippetDetailComponent;
import java.awt.Component;
import java.awt.Frame;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author mmazzocchetti
 */
public class GlobalListener implements NativeKeyListener {

        private Queue<Integer> multipleKeyHandler = new ConcurrentLinkedQueue<>();
        private MainFrame frame;

        public GlobalListener(MainFrame aThis) {
                this.frame = aThis;
        }

        @Override
        public void nativeKeyTyped(NativeKeyEvent nke) {
                //Nulla da fare
        }

        @Override
        public void nativeKeyPressed(NativeKeyEvent nke) {
                if (!multipleKeyHandler.contains(nke.getKeyCode())) {
                        multipleKeyHandler.add(nke.getKeyCode());
                        StringBuffer sb = new StringBuffer("Key Pressed: ");
                        Boolean ctrlContenuto = false;
                        Boolean altContenuto = false;
                        Boolean tContenuto = false;
                        for (Integer i : multipleKeyHandler) {
                                sb.append(NativeKeyEvent.getKeyText(i) + i);
                                if (i.equals(NativeKeyEvent.VC_CONTROL)) {
                                        ctrlContenuto = true;
                                }
                                if (i.equals(NativeKeyEvent.VC_T)) {
                                        tContenuto = true;
                                }
                                if (i.equals(NativeKeyEvent.VC_ALT)) {
                                        altContenuto = true;
                                }
                        }
                        if (ctrlContenuto && tContenuto && altContenuto) {
                                makeWindowAppear();
                        }
                        System.out.println(sb.toString());
                        if (nke.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
                                try {
                                        GlobalScreen.unregisterNativeHook();
                                } catch (NativeHookException e1) {
                                        e1.printStackTrace();
                                }
                        }
                }
        }

        @Override
        public void nativeKeyReleased(NativeKeyEvent nke) {
                multipleKeyHandler.remove(nke.getKeyCode());
        }

        private void makeWindowAppear() {
                frame.setVisible(false);
                frame.setVisible(true);
                frame.setState(Frame.ICONIFIED);
                frame.setState(Frame.NORMAL);
                GitlabModel snippet = new GitlabModel();
                snippet.setVisibility(GitlabVisibility.PUBLIC);
                SnippetDetailComponent panel = new SnippetDetailComponent(snippet, frame);
                panel.setVisible(true);
                panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                frame.setContentPane(panel);
                frame.pack();
        }

}
