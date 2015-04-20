package exception;

// bai 2 de LTHDT
public class ExceptionTest {

    // Khai bao nem ngoai le
    public static void causeException() throws MyException {
        throw new MyException();
    }

    // xu ly ngoai le tai cho
    public static void handleException() {
        try {
            causeException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    // nem di tiep
    public static void rethrowException() throws MyException {
        try {
            causeException();
        } catch (MyException e) {
            throw e;
        }
    }

    // xu ly ngoai le ngoai phuong thuc sinh ngoai le

    public static void rehandleExeption() {
        try {
            rethrowException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

}

class MyException extends Exception {

}

// bai 2 de 2
class VanHoaPham {
    
}

interface QuaTang {
    
}

class Sach extends VanHoaPham implements QuaTang {
    
}

