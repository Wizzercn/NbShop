package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单来源
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderOrderSource {
    PC("pc", "电脑端"),
    WAP("wap", "移动端"),
    WECHAT("wechat", "微信端"),
    API("api", "API接口");

    private String value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderOrderSource(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public String value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static ShopOrderOrderSource from(String value) {
        for (ShopOrderOrderSource t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderOrderSource: " + value);
    }

}
