package ro.teamnet.zerotohero.gc;

/**
 * Created by Gabi on 01-Jul-16.
 */
public class DemoObject {
    private static final int bufferSize = 100000;
    private String temp;
    private String objectRef;
    private static int count = 0;


    public DemoObject() {
        this.objectRef = this.toString();
        temp=null;
        for(int i=1;i<100;i++) {
            temp+='a';
        }
        count++;
    }

}
