public class AplikasiTodoList {

    public static String[] model = new String[5];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewShowTodoList();


    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        for (var i = 0; i < model.length ; i++) {
            var todo = model[i];
            var nomor = i + 1;

            if(todo != null){
                System.out.println(nomor + ". " + todo);
        }

        }
    }

    public static void testShowTodoList(){
        model[0] = "Belajar java";
        model[1] = "Membuat duit cuan";
        showTodoList();
    }

    /**
     * Menambahkan todo list
     */
    public static void addTodoList(String todo){
        //cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length ; i++) {
            if(model[i] == null ){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //jika penuh, kita resize ukuran array menjadi 2x lipat
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length ; i++) {
                model[i] = temp[i];
            }
        }

        for (var i = 0; i < model.length; i++) {
    if(model[i] == null){
        model[i] = todo;
        break;
            }
        }
    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke. "+ i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo list
     */
    public static boolean removeTodoList(Integer number){
        if((number -1) >= model.length) {
            return false;
        }else if (model[number -1] == null){
            return false;
        } else {
            for (int i = (number - 1); i < model.length ; i++) {
                if(i == (model.length -1)){
                    model[i] = null;
                }else{
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static void testRemoveTodoList(){
        addTodoList("1");
        addTodoList("2");
        addTodoList("3");
        addTodoList("4");
        addTodoList("5");
        var result = removeTodoList(10);
        System.out.println(result);



        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
        System.out.println(model.length);
    }

    /**
     * Function untuk input data
     * @param info
     * @return
     */
    public static String input(String info){
        System.out.print(info + " : ");
    String data = scanner.nextLine();
    return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi"+ name);

        var channel = input("Instagram");
        System.out.println("IG mu "+ channel);
    }
    /**
     * menampilkan menu todo list
     */
    public static void viewShowTodoList(){
   while(true){

       showTodoList();

       System.out.println("Menu");
       System.out.println("1. Tambah");
       System.out.println("2. Hapus");
       System.out.println("x. Keluar");

       var input = input("Pilih Menu Ke-");
       if(input.equals("1")){
           viewAddTodoList();
       } else if (input.equals("2")){
           viewRemoveTodoList();
       }else if(input.equals("x")) {
       break;
       }else {
           System.out.println("Pilihan tidak dimengerti");
       }
   }
    }

    public static void testViewTodoList(){
        addTodoList("1");
        addTodoList("2");
        addTodoList("3");
        addTodoList("4");
        addTodoList("52");
        viewShowTodoList();
    }

    /**
     * menampilkan view add Todo List
     */
    public static void viewAddTodoList(){
        System.out.println("Menambah TODOLIST");
        var todo = input("Todo ( x untuk keluar)");
        if(todo.equals("x")){
            //batal
        } else {
            addTodoList(todo);
        }
    }

    /**
     * menampilkan view remove todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("Menghapus TODOLIST");
        var number = input("Nomor yang akan diapus (X jika ingin batal)");

        if(number.equals("x")){
            //batal
        } else {
          boolean success =  removeTodoList(Integer.valueOf(number));
          if(!success){
              System.out.println("gagal menghapus todolist: " + number);
          }
        }
    }

    public static void testViewRemoveTodoList(){
    addTodoList("satu");
    addTodoList("dsatu");
    addTodoList("tsatu");

        showTodoList();
        viewRemoveTodoList();

        showTodoList();

    }

}
