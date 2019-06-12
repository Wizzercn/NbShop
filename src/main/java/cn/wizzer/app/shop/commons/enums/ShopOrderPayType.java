package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单支付方式
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderPayType {
    CASH("cash", "货到付款"),
    MONEY("money", "账户余额"),
    WXPAY("wxpay", "微信支付"),
    ALIPAY("alipay", "支付宝支付");

    private String value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderPayType(String value, String text) {
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

    public static ShopOrderPayType from(String value) {
        for (ShopOrderPayType t : values()) {
            if (t.value.equals(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderPayType: " + value);
    }

}
