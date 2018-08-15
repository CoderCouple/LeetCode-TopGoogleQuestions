class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1.length==0 || nums2.length==0)
            return new int [0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                if(!list.contains(nums1[i]))
                    list.add(nums1[i]);
                i++;j++;
            } else if(nums1[i]<nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int [] array = new int [list.size()];
        for(int k=0;k<list.size();k++)
            array[k]=list.get(k);
        return array;
    }
}
