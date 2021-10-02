class CaesarCipher{
	private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower = shiftedAlphabet.toLowerCase();
        for (int i=0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower.charAt(idxLower);
                    sb.setCharAt(i, c);
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
    	CaesarCipher c = new CaesarCipher(26 - mainKey);
        String decrypt = c.encrypt(input);
        return decrypt;
    }
    
    public void testEncrypt(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptedMessage = encrypt(message);
        System.out.println(encryptedMessage);
        System.out.println("Decrypted message: " + decrypt(encryptedMessage));
    }
}
public class TestCaesarCipher {
	
	public static void main(String[] args) {
		CaesarCipher c=new CaesarCipher(2);
    	String encrypt=c.encrypt("dscjscsdjcdscsdcsdcdc");
    	System.out.println(encrypt);
	}

}
