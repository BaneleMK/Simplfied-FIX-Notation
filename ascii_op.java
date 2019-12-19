package ascii.ascii_op;

/**
 * ascii_op
 */
public class ascii_op {
    private String _message;
    private long sum = 0;
    private long checksum = 0;

    public ascii_op(String message){
        _message = message;

        ascii_sum();
        ascii_checksum();
    }

    private void ascii_sum(){
        int length = _message.length();
        for (int i = 0; i < length ; i++) {
            // the '[space]' and '|' represent the start of header ascii which has a value of 1
            if (_message.charAt(i) == ' ' || _message.charAt(i) == '|')
                sum += 1;
            else
                sum += _message.charAt(i);
        }
    }

    public boolean checksum_verification(String message){
        /*
            i take the string store it...maybe not i find the checksum 1st things 1st
        */
        return true;
    }

    private void ascii_checksum(){
        checksum = sum % 256;
    }

    public long get_sum(){
        return sum;
    }

    public long get_checksum(){
        return checksum;
    }
}