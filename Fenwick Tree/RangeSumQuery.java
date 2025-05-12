class NumArray {
    private int[] f;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        f=new int[nums.length+1];
        for(int j=0;j<nums.length;j++){
            int i=j+1;
            while(i<f.length){
                f[i]+=nums[j];
                i+=(i&-i);
            }
        }
    }
    
    public void update(int i, int val) {
        int temp=nums[i];
        nums[i]=val;
        i++;
        while(i<f.length){
            f[i]-=temp;
            f[i]+=val;
            i+=(i&-i);
        }
    }
    private int sum(int i){
        int res=0;
        while(i>0){
            res+=f[i];
            i-=(i&-i);
        }
        return res;
    }
    public int sumRange(int left, int right) {
        return sum(right+1)-sum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */