package com.sparrow.zg.abstructFactory;
class DateAccessReflect{
		public IUserDao getUserDao (Class<?> cls) throws IllegalAccessException, InstantiationException {
			return (IUserDao)cls.newInstance();
		}
		public IDepartment getDepartment(Class<?> cls) throws IllegalAccessException, InstantiationException {
			return (IDepartment)cls.newInstance();
		}
}

public class ReflectAbsructFactory {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		DateAccessReflect dar = new DateAccessReflect();
		IDepartment id = dar.getDepartment(SqlServerDepartment.class);
		id.insert(new User());
	}
}
