package QueuePackage;
import java.util.*;

// My Implementation of the Event Queue
public class SimulationEventQueue implements SimulationEventInterface {
    private double currentTime;
    private Vector<SimulationEvent> queue;

    // constructor
    public SimulationEventQueue() {
        queue = new Vector<SimulationEvent>();
        currentTime = 0.0;
    }

    public void add(SimulationEvent event) {
        if (event.getTime() < currentTime) {
            System.out.println("Cannot add new entry.");
            return;
        }
        else if(queue.isEmpty()){
            queue.add(event);
        }
        else {
            System.out.println("Adding the event "+event+" at time "+event.getTime());
            int index = 0;
            while (index < queue.size() && queue.get(index).getTime() <= event.getTime()) {
                index++;
            }
            queue.add(index, event);
        }

    }

    public SimulationEvent remove() {
        SimulationEvent front = null;
        if(queue.isEmpty()){
            throw new EmptyQueueException("Queue is empty");
        }
        else{
           front = queue.get(0);
           queue.remove(0);
           currentTime = front.getTime();
        }
        return front;
    }

    public SimulationEvent peek(){
        SimulationEvent front = null;
        if(queue.isEmpty()){
            throw new EmptyQueueException("Queue is empty");
        }
        else{
            front = queue.get(0);
        }
        return front;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void clear(){
        queue.clear();
    }

    public double getCurrentTime() {
        return currentTime;
    }

    public int getSize() {
        return queue.size();
    }

    public void process() {

    }

    @Override
    public double getTime(){
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getPostActionReport() {
        return "";
    }

}
