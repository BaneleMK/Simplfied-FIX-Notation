package ascii.ascii_op;

/**
 * ascii_op
 */
public class ascii_op {
    private String _message;
    private long _sum = 0;
    private long _checksum = 0;

    public ascii_op(String message){
        _message = message;

        _sum = ascii_sum(_message);
        _checksum = ascii_checksum(_message);
    }

    private long ascii_sum(String data){
        long tempsum = 0;
        int length = data.length();
        for (int i = 0; i < length ; i++) {
            // the '[space]' and '|' represent the start of header ascii which has a value of 1
            if (data.charAt(i) == ' ' || data.charAt(i) == '|')
                tempsum += 1;
            else
                tempsum += data.charAt(i);
        }
        return tempsum;
    }

    public void makefix(String message_elements){
        String elements [] = message_elements.split(";");
        String fixmessage = "ID="+elements[0]+
        "|Instr="+elements[1]+
        "|Quant="+elements[2]+
        "|Market="+elements[3]+
        "|Price="+elements[4]+"|";
        fixmessage += "10="+ascii_checksum(fixmessage);
        System.out.println(fixmessage);
    }

    public boolean checksum_verification(String message){
        /*
            i take the string store it...maybe not i find the checksum 1st things 1st
        */
        return true;
    }

    private long ascii_checksum(String data){
        long temp_sum = ascii_sum(data);
        long temp_checksum = 0;
        temp_checksum = temp_sum % 256;
        return temp_checksum;
    }

    public long get_sum(){
        return _sum;
    }

    public long get_checksum(){
        return _checksum;
    }
}