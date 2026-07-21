class MyCircularQueue {
    public int begOfQueue=-1;
    public int topOfQueue=-1;
    public int queue[];
    public int k;
    public MyCircularQueue(int k) {
        this.queue=new int[k];
        this.k=k;
        Arrays.fill(queue,-1);
    }
    public boolean isFull(){
        if(topOfQueue+1==begOfQueue){
            return true;
        }else if(begOfQueue==0 && topOfQueue==k-1){
            return true;
        }else{
            return false;
        }
    }
    public boolean isEmpty(){
        if(begOfQueue==-1){
            return true;
        }else{
            return false;
        }
    }
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else if(isEmpty()){
            begOfQueue=0;
            topOfQueue++;
            queue[topOfQueue]=value;
            return true;
        }else{
            if(topOfQueue+1==k){
                if(queue[0]!=-1){ 
                    return false;
                }else{
                    topOfQueue=0;
                }
            }else{
                topOfQueue++;
            }
            queue[topOfQueue]=value;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            int val=queue[begOfQueue];
            queue[begOfQueue]=-1;
            
            if(begOfQueue==topOfQueue){
                begOfQueue=topOfQueue=-1;
            }else if(begOfQueue+1==k){
                begOfQueue=0;
            }else{
                begOfQueue++;
            }
            return true;
        }
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
            return queue[begOfQueue];
        }
    }

    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }else{
            return queue[topOfQueue];
        }
    }
    
    
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */