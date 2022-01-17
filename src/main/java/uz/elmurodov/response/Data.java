package uz.elmurodov.response;

import lombok.Getter;

/**
 * @param <B> Body
 */
@Getter
public class Data<B> {
    private B data;
    private Long total;

    public Data(B data) {
        this(data, 0L);
    }

    public Data(B data, Long total) {
        this.data = data;
        this.total = total;
    }
}
