/**
 * 
 */
package br.com.springessential.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author fernando
 *
 */
public class SenhaUtils {

    /**
     * @param senha
     * @return String
     */
    public static String gerarBCrypt(String senha) {
	if (senha == null) {
	    return senha;
	}

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	return bCryptPasswordEncoder.encode(senha);
    }

    /**
     * @param senha
     * @param senhaEncoded
     * @return boolean
     */
    public static boolean senhaValida(String senha, String senhaEncoded) {
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	return bCryptPasswordEncoder.matches(senha, senhaEncoded);
    }

}
