/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

/**
 *
 * @author Jatin
 */
public class RandomStringGenerator {
    public static String generateRandomString(int length) throws Exception{
        StringBuffer buffer = new StringBuffer();
        String characters = "";
        characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!#-";
        int charactersLength = characters.length();
        for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
    }
    
}
