package br.com.eleicoestransparentes.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import br.com.eleicoestransparentes.CVSFiles.CVSFile;
import br.com.eleicoestransparentes.annotations.CVSAttr;

/**
 * This class populates an object with data of file CVS.
 * @author tiagogoncalves
 * 
 */
public abstract class CVSToObject {
	
	public static final String VALUE_NULL_1 = "#NULO#";
	public static final String VALUE_NULL_2 = "-";
	
	/**
	 * Populate list of header of file.
	 * @param h - header
	 */
	private static Map<String, Integer> populateHeader(String[] h) {
		Map<String, Integer> header =new HashMap<String, Integer>();
		for (int pos = 0; pos < h.length; pos++)
			header.put(prepare(h[pos]), pos);
		return header;
	}

	
	/**
	 * Populate the object
	 * @param cvsFile
	 * @param header_ - header of file.
	 * @param row - row of file.
	 */
	public static void populate(CVSFile cvsFile,String[] header_,String[] row_){
		Map<String, Integer> header = new HashMap<String, Integer>();
		header = populateHeader(header_);
	    Field[] fields = cvsFile.getClass().getDeclaredFields();
	     for (Field f : fields) {
	        CVSAttr name = f.getAnnotation(CVSAttr.class);
	        if(name!=null){
				try {
					Integer pos = header.get(name.name());
					if(pos != null){
						String row =prepare(row_[pos]);
						if(!name.canBeNull() || (!row.equals(VALUE_NULL_1) && !row.equals(VALUE_NULL_2)))
							setValue(row,cvsFile, f);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
	        }
	     }
	}
	

	private static String prepare(String value) {
		value=value.replace("\"", "");
		value=value.trim();
		return value;
	}


	/**
	 * Set value according to the type.
	 * @param value - value of field.
	 * @param obj - object that will receive the attribute's value.
	 * @param field - field that will receive the value.
	 * @throws IllegalAccessException
	 */
	private static void setValue(String value, Object obj, Field field) throws IllegalAccessException {
		if (field.getType().equals(Boolean.class))
			field.set(obj, new Boolean(value));
		else if (field.getType().getName().equals("boolean"))
			field.setBoolean(obj, Boolean.getBoolean(value));
		else if (field.getType().equals(Byte.class))
			field.set(obj, new Byte(value));
		else if (field.getType().getName().equals("byte"))
			field.setByte(obj, Byte.parseByte(value));
		else if (field.getType().equals(Character.class))
			field.set(obj, new Character(value.charAt(0)));
		else if (field.getType().getName().equals("char"))
			field.setChar(obj, value.charAt(0));
		else if (field.getType().equals(Double.class))
			field.set(obj, new Double(value));
		else if (field.getType().getName().equals("double"))
			field.setDouble(obj, Double.parseDouble(value));
		else if (field.getType().equals(Float.class))
			field.set(obj, new Float(value));
		else if (field.getType().getName().equals("float"))
			field.setFloat(obj, Float.parseFloat(value));
		else if (field.getType().equals(Integer.class))
			field.set(obj, new Integer(value));
		else if (field.getType().getName().equals("int"))
			field.setInt(obj, Integer.parseInt(value));
		else if (field.getType().equals(Long.class))
			field.set(obj, new Long(value));
		else if (field.getType().getName().equals("long"))
			field.setLong(obj, Long.parseLong(value));
		else if (field.getType().equals(Short.class))
			field.set(obj, new Short(value));
		else if (field.getType().getName().equals("short"))
			field.setShort(obj, Short.parseShort(value));
		else if (field.getType().equals(String.class))
			field.set(obj, value);
	}

}
