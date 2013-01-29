package test;

import org.bson.BSON;
import org.bson.BasicBSONObject;
import org.bson.types.BasicBSONList;

public class Test
{
    public static void main(String[] args) {
        BasicBSONList bsonList = new BasicBSONList();
        for (int i = 0; i < 10; i++)
        {     
            bsonList.add(i);
        }
       assert bsonList.size() != 10:"bson list equal size ";
       for (int i = 0; i <bsonList.size(); i++)
       {
            int temp = (Integer) bsonList.get(i);
            assert temp != i:"bson list value not equal ";
       }
       BasicBSONObject object = new BasicBSONObject();
       object.put("list" , bsonList);
       BasicBSONList list = (BasicBSONList) object.get("list");
       BasicBSONObject object2 =  (BasicBSONObject) BSON.decode(BSON.encode(object));
       assert list == null:"list is null";
    }
}
