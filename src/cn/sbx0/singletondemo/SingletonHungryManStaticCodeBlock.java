package cn.sbx0.singletondemo;

import java.io.IOException;
import java.util.Properties;

/**
 * 静态代码块
 */
public class SingletonHungryManStaticCodeBlock {
    public static final SingletonHungryManStaticCodeBlock INSTANCE;
    private String value;

    static {
        Properties properties = new Properties();
        try {
            properties.load(SingletonHungryManStaticCodeBlock.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        INSTANCE = new SingletonHungryManStaticCodeBlock(properties.getProperty("value"));
    }

    private SingletonHungryManStaticCodeBlock(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SingletonStaticCodeBlock{" +
                "value='" + value + '\'' +
                '}';
    }
}
