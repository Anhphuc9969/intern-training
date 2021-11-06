
public class test {


    public interface Ex05_Annotation {// functional interface

        void showMessage(String mess);

        String LisstMess(String a);

        default String getMess(String mess) {
            return mess;
        }

        @Override
        boolean equals(Object other);

    }


    public static void main(String[] args) {
        Ex05_Annotation ex = new Ex05_Annotation() {
            @Override
            public void showMessage(String mess) {

                System.out.println(mess);
            }

            @Override
            public String LisstMess(String a) {
                return null;
            }
        };


    }
}