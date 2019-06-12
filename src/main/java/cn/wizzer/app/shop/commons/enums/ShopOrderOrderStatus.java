package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderOrderStatus {
    ACTIVE(0, "活动"),
    CANNEL(1, "已取消"),
    FINISH(2, "已完成"),
    DELETE(3, "已删除");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderOrderStatus(int value, String text) {
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

    public static ShopOrderOrderStatus from(int value) {
        for (ShopOrderOrderStatus t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderOrderStatus: " + value);
    }

}
