/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.drakonkat.gitlabsnippetplugin.frame.keylistener;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
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

        @Override
        public void nativeKeyTyped(NativeKeyEvent nke) {
                //Nulla da fare
        }

        @Override
        public void nativeKeyPressed(NativeKeyEvent nke) {
                if (!multipleKeyHandler.contains(nke.getKeyCode())) {
                        multipleKeyHandler.add(nke.getKeyCode());
                        StringBuffer sb = new StringBuffer("Key Pressed: ");
                        for (Integer i : multipleKeyHandler) {
                                sb.append(NativeKeyEvent.getKeyText(i));
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

}
