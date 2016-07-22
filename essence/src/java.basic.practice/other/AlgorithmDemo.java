package src.java.basic.practice.other;

/**
 * Created by linzh on 2016/7/5.
 */
public class AlgorithmDemo {

    public static void insertSort(int a[]){
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            int j = i -1;
            for (;j>=0 && a[j] < temp;j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }

    public static void shellSort(int a[]){
        int n = a.length;
        int d = n;
        int temp = 0;
        while(true){
            d = (int)Math.ceil(d/2);
            for (int i = 0; i < d; i++) {
                for (int j = 1; j*d < n; j++) {
                    temp = a[j*d];
                    int k = j - 1;
                    for (; k >=0 && a[k*d] < temp; k--) {
                        a[(k+1)*d] = a[k*d];
                    }
                    a[(k+1)*d] = temp;
                }
            }
            if(d==1) break;
        }
    }

    public static void selectSort(int a[]){
        for (int i = 0; i < a.length-1; i++) {
            int temp = a[i+1];
            int index = i+1;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] > temp){
                    temp = a[j];
                    index = j;
                }
            }
            if(a[i] < temp){
                a[index] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void heapSort(int a[]){
//        for (int i = a.length-1; i >=0; i--) {
//            createHeap(a,i);
//            swap(a,0,i);
//        }

        //初始化堆
        for (int i = (a.length-1)/2; i >=0; i--) {
            adjustHeap(a,i,a.length-1);
        }
        //每次调整堆
        for (int i = a.length-1; i >=0 ; i--) {
            adjustHeap(a,0,i);
            swap(a,0,i);
        }
    }

    public static void swap(int a[],int i,int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void adjustHeap(int a[],int adjustIndex,int lastIndex){
        int leftIndex = adjustIndex*2+1;
        int rightIndex = adjustIndex*2+2;
        int tempIndex = adjustIndex;
        if(leftIndex <= lastIndex && a[adjustIndex] > a[leftIndex]){
            tempIndex = leftIndex;
        }
        if(rightIndex <=lastIndex && a[rightIndex] < a[tempIndex]){
            tempIndex = rightIndex;
        }
        if(tempIndex != adjustIndex){
            swap(a,tempIndex,adjustIndex);
            adjustHeap(a,tempIndex,lastIndex);
        }
    }

    public static void createHeap(int a[],int lastIndex){
        for (int i = lastIndex/2; i >=0; i--) {
            int k = i;
            while (2*k +1 <= lastIndex){
                int smallIndex = 2*k + 1;
                if(smallIndex < lastIndex){
                    if(a[smallIndex] < a[smallIndex + 1]){
                        smallIndex++;
                    }
                }
                if(a[k] < a[smallIndex]){
                    swap(a,k,smallIndex);
                }else {
                    break;
                }
            }
        }
    }

    public static void bubbleSort(int a[]){
        for (int i = a.length-1; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                if((j+1)<=i && a[j] < a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }

    public static void quickSortInvoke(int a[]){
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int a[],int startIndex,int endIndex){
        int i = startIndex;
        int j = endIndex;
        if(i >= j){
            return;
        }
        int key = a[i];
        while (i < j){
            while (i < j && a[j] <= key){
                --j;
            }
            a[i] = a[j];
            while (i < j && a[i] >= key){
                ++i;
            }
            a[j] = a[i];
        }
        a[i] = key;
        quickSort(a,startIndex,i-1);
        quickSort(a,j+1,endIndex);
    }

    public static void mergeSortInvoke(int a[]){
        mergeSort(a,0,a.length-1);
    }

    public static void mergeSort(int a[],int startIndex,int endIndex){
        if(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex)/2;
            mergeSort(a,startIndex,middleIndex);
            mergeSort(a,middleIndex+1,endIndex);
            merge(a,startIndex,middleIndex,endIndex);
        }
    }

    public static void merge(int[] data, int left, int center, int right) {
        int [] tmpArr=new int[data.length];
        int mid=center+1;
        //third记录中间数组的索引
        int third=left;
        int tmp=left;
        while(left<=center&&mid<=right){
            //从两个数组中取出最小的放入中间数组
            if(data[left]<=data[mid]){
                tmpArr[third++]=data[left++];
            }else{
                tmpArr[third++]=data[mid++];
            }
        }
        //剩余部分依次放入中间数组
        while(mid<=right){
            tmpArr[third++]=data[mid++];
        }
        while(left<=center){
            tmpArr[third++]=data[left++];
        }
        //将中间数组中的内容复制回原数组
        while(tmp<=right){
            data[tmp]=tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
//        insertSort(a);
//        shellSort(a);
//        selectSort(a);
//        heapSort(a);
//        bubbleSort(a);
//        quickSortInvoke(a);
        mergeSortInvoke(a);
        printSortResult(a);
    }

    public static void printSortResult(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
        System.out.println("");
    }
}

class ThreadDemo extends Thread{

}

