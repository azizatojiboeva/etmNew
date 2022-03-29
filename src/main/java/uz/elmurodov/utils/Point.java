package uz.elmurodov.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Aziza Tojiboyeva
 * @date 19 Wednesday  January 17 : 02
 */
@Getter
@Setter
@AllArgsConstructor
public class Point extends org.postgresql.geometric.PGpoint{
    public Point(double x, double y){
        super(x,y);
    }
}
