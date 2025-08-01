import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class MyException extends Exception
{
    public MyException(String str)
    {
        super(str);
    }
}

public class Prog {
    static int LEN = 6;

    public static void main(String[] args)
    {
        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        try
        {
            String[] split = str.split(" ");
            
            _check_len(split);
            _check_date(split[3]);
            _check_phone(split[4]);
            _check_sex(split[5]);
            _to_file(split[0] + ".txt", str);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void _check_len(String[] split) throws MyException
    {
        if (split.length != LEN) throw new MyException("Invalid string");
    }

    private static void _check_date(String str) throws MyException
    {
        try 
        {
            LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        catch (Exception ex) 
        {
            throw new MyException("Invalid date");
        }
    }

    private static void _check_phone(String str) throws MyException
    {
        try
        {
            Long.parseLong(str);
        }
        catch (Exception ex)
        {
            throw new MyException("Invalid phone");
        }
    }

    private static void _check_sex(String str) throws MyException
    {
        if (str.compareToIgnoreCase("f") == 0 || str.compareToIgnoreCase("m") == 0) return ;
        throw new MyException("invalid sex");
    }

    private static void _to_file(String name, String str) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name));
    
        writer.write(str);
        writer.newLine();
        writer.close();
    }
}
