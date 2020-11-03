import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class text {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void delete(){
        Boolean delete = redisTemplate.delete("findGoodsList" + 1 + 10);
        System.out.println(delete);
    }

    public static void main(String[] args) {
        text text = new text();
        text.delete();
    }
}
