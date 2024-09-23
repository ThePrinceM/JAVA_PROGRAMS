public class SearchMatrix {
    int matrix[][];
    int a;

    SearchMatrix(){}

    SearchMatrix(int a){
        this.a=a;
    }

    SearchMatrix(int matrix[][]){
        this.matrix=matrix;
    }

    void searchMe(int a){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==a){
                    System.out.println("it is present on the location: "
                    +"["+i+","+j);
                } 
                else{
                    System.out.println("nhi mil rha yaar");
                }
            }
        }
    }

    int reorder(){
        
    }


}
