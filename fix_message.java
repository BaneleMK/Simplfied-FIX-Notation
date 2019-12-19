package ascii.fix_message;

/**
 * ascii_op
 */
public class fix_message {

    private long ascii_sum(final String data){
        long tempsum = 0;
        final int length = data.length();
        for (int i = 0; i < length ; i++) {
            // the '[space]' and '|' represent the start of header ascii which has a value of 1
            if (data.charAt(i) == ' ' || data.charAt(i) == '|')
                tempsum += 1;
            else
                tempsum += data.charAt(i);
        }
        return tempsum;
    }

    // the message_elements are as follows "ID;iNSTRUMENT;QUANTITY;MARKET;PRICE"
    // example of message_elements "0001;guitar;4;rando;10000"
    // example output "ID=0001|Instr=guitar|Quant=4|Market=rando|Price=10000|10=185"
    public String makefix(final String message_elements){
        final String elements [] = message_elements.split(";");
        String fixmessage = 
        "ID="+elements[0]+
        "|Instr="+elements[1]+
        "|Quant="+elements[2]+
        "|Market="+elements[3]+
        "|Price="+elements[4]+"|";
        fixmessage += "10="+ascii_checksum(fixmessage);
        return fixmessage;
    }

    // This is just taking the full fixmessage recieved
    // it checking if the checksum matches up or not to the data contained
    public boolean checksum_verification(final String message){
        final String elements [] = message.split("10=");
        if (ascii_checksum(elements[0]) != Integer.valueOf(elements[1]))
            return false;
        else 
            return true;
    }

    // this takes the data without the checksum and counts the ascii to come up with the checksum number
    private long ascii_checksum(final String data){
        final long temp_sum = ascii_sum(data);
        long temp_checksum = 0;
        temp_checksum = temp_sum % 256;
        return temp_checksum;
    }

}