package catalogo.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import catalogo.annotation.BDField;

public class DAOHelper {

	public static String createInsertQuery(Class<?> entity){
			
			StringBuilder start = new StringBuilder("INSERT INTO ");
			start.append(entity.getSimpleName());
			
			StringBuilder b1 = new StringBuilder();
			b1.append("(");
			
			StringBuilder b2 = new StringBuilder();
			b2.append("(");
			
			Field fields[] = entity.getDeclaredFields();
			int size = entity.getDeclaredFields().length;
			
			int i = 0;
			for (Field field : fields) {
				field.setAccessible(true);
				if(field.getName() != "id"){
					for (Annotation annotation :field.getDeclaredAnnotations()){
						BDField bdField = (BDField) annotation;
						if(annotation.annotationType() == BDField.class){
							if (i == size-1){
								b1.append(bdField.value()).append(")");
								b2.append("?)");
							}else{
								b1.append(bdField.value()).append(", ");
								b2.append("?, ");
							}
						}
					}
				}
				i++;
			}
			
			start.append(b1).append(" values ").append(b2).append(";");
			
			return start.toString();
	}
	
	public static String createRemoveQuery(Class<?> entity){
		
		StringBuilder start = new StringBuilder("DELETE FROM");
		start.append(" ").append(entity.getSimpleName());
		
		start.append(" WHERE cod = ?").append(";");
		
		return start.toString();
	}
	
	public static String createUpdateQuery(Class<?> entity){
		
		StringBuilder start = new StringBuilder("UPDATE ");
		start.append(entity.getSimpleName()).append(" SET ");

		StringBuilder b1 = new StringBuilder();
		
		Field fields[] = entity.getDeclaredFields();
		int size = entity.getDeclaredFields().length;
		
		int i = 0;
		for (Field field : fields) {
			field.setAccessible(true);
			if(field.getName() != "id"){
				for (Annotation annotation : field.getDeclaredAnnotations()){
					BDField bdField = (BDField) annotation;
					if(annotation.annotationType() == BDField.class){
						if (i == size-1){
							b1.append(bdField.value()).append(" = ?");
						}else{
							b1.append(bdField.value()).append(" = ?, ");
						}
					}
				}
			}
			i++;
		}
		
		start.append(b1).append(" WHERE cod = ?").append(";");
		
		return start.toString();
	}
	
}
