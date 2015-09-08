package JsonManage;
import java.io.FileReader;
import com.google.gson.*;

class JsonEncodeDemo {

   public static void main(String[] args){
      JsonObject obj = new JsonObject();

      obj.addProperty("name", "foo");
      obj.addProperty("num", new Integer(100));
      obj.addProperty("balance", new Double(1000.21));
      obj.addProperty("is_vip", new Boolean(true));

      System.out.print(obj);
   }
}