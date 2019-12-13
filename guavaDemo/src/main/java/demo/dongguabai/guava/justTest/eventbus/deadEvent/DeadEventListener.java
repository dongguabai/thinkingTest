package demo.dongguabai.guava.justTest.eventbus.deadEvent;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @author dongguabai
 * @date 2019-04-01 14:00
 */
public class DeadEventListener {

    @Subscribe
    public void deadEventMethod(DeadEvent deadEvent){
        System.out.println("DeadEvent_Source_Class："+deadEvent.getSource().getClass());
        System.out.println("DeadEvent_Source："+deadEvent.getSource());
        System.out.println("DeadEvent_Event："+deadEvent.getEvent());
    }
}
