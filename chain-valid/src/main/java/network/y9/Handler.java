package network.y9;

import java.util.Objects;

public abstract class Handler<T> {

    protected Handler next;

    private void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(User user);


    public static class Builder<T> {
        private Handler<T> head;

        private Handler<T> tail;


        public Builder<T> addHandler(Handler handler){
            if(Objects.isNull(this.head)){
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }
        public Handler<T> build(){
            return this.head;
        }


    }



}
