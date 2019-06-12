package cn.wizzer.app.shop.commons.enums;

/**
 * 订单售后类型
 * Created by wizzer on 2019/6/12
 */
public enum ShopOrderServiceType {
    MEMBER(0, "退款退货"),
    WHOLESALE(1, "退款"),
    DEALER(2, "退货"),
    DEALER1(3, "退款退货");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderServiceType(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public int value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static ShopOrderServiceType from(int value) {
        for (ShopOrderServiceType t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderServiceType: " + value);
    }

}
