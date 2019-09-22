/**
 * 
 */
package br.com.springessential.responses;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author fernando
 *
 */
@NoArgsConstructor
public class Response<T> {
    
    @Getter @Setter private T data;
    @Getter(value = AccessLevel.NONE) @Setter private List<String> errors;
    
    /**
     * @return List
     */
    public List<String> getErrors() {
	if (this.errors == null) {
	    this.errors = new ArrayList<String>();
	}
	return errors;
    }

}
