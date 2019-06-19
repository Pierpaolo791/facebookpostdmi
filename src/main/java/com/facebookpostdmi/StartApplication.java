
package com.facebookpostdmi;

import java.util.Timer;

import com.facebookpostdmi.factory.FactoryPost;
import com.facebookpostdmi.factory.JsonFactoryPost;

public class StartApplication {
    
    public static void main(String[] args) {
       String[] urls = {
    		  
    		   "https://bridge.suumitsu.eu/?action=display&bridge=Facebook&u=Inf.UniCt&media_type=all&limit=-1&format=Json",
    		   "https://bridge.suumitsu.eu/?action=display&bridge=Facebook&u=Mat.UniCt&media_type=all&limit=-1&format=Json",
    		   "https://bridge.suumitsu.eu/?action=display&bridge=Facebook&u=DMI.UNICT&media_type=all&limit=-1&format=Json"
       };
       
       new Timer().scheduleAtFixedRate(new FactoryPost(urls), 0, 1000);;
       
    }
}
