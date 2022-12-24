/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DEA.PhoniexAirlines.tickets.model;
import java.util.*;
import java.nio.charset.*;
/**
 *
 * @author Raffael
 */
public class ticketidgenerator {
    
    public String generateTID(int idlength){
        
        byte[] bound = new byte[256];
        
        new Random().nextBytes(bound);
        
        String str = new String(bound, Charset.forName("UTF-8"));
        
        StringBuilder build = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            
            char ch = str.charAt(i);
            
            if(((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (idlength > 0)){
               
                build.append(ch);
                idlength--;
            }
        }
        
        String generatedid = build.toString();
        
        return generatedid;
        
    }
    
    
}
