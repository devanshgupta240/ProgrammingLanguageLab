package calculator;

import java.util.EmptyStackException;
import java.util.Stack;

public class HelperMethods {
    
    public static String CalculateExpression(String content)
    {
        if(content.charAt(0) == '+' || content.charAt(0) == '-')
            content = "0" + content;
        Stack<Character> s = new Stack<Character>();
        Stack<Double> s1 = new Stack<Double>();           
        Double num1, num2;
        String postfix = "";
        for(int i=0;i<content.length();)
        {
            if(content.charAt(i) == ' ')
            {
                i++;
                continue;
            }
            if(content.charAt(i) >= '0' && content.charAt(i) <= '9')
            {
                String temp ="";
                while(i < content.length() && (content.charAt(i) == '.' ||(content.charAt(i) >= '0' && content.charAt(i) <= '9')))
                    temp += content.charAt(i++);
                s1.push(Double.parseDouble(temp));
                postfix += temp;
            }
            else if(content.charAt(i) == '+' || content.charAt(i) == '-')
            {
                while(!s.empty())
                {
                    try
                    {
                        num2 = s1.pop();
                        num1= s1.pop();
                    }
                    catch (EmptyStackException e)
                    {
                        return null;
                    }
                    switch(s.peek())
                    {
                        case '+' :  s1.push(num1+num2);
                                    break;
                        case '-' :  s1.push(num1-num2);
                                    break;
                        case '*' :  s1.push(num1*num2);
                                    break;
                        case '/' :  s1.push(Math.round((num1/num2) * 100)/100.0);
                                    break;
                    }
                    postfix += s.peek();
                    s.pop();
                }
                s.push(content.charAt(i++));
            }
            else if(content.charAt(i) == '*' || content.charAt(i) == '/')
            {
                while(!s.empty() && (s.peek() == '*' || s.peek() == '/'))
                {
                    try
                    {
                        num2 = s1.pop();
                        num1= s1.pop();
                    }
                    catch (EmptyStackException e)
                    {
                        return null;
                    }
                    switch(s.peek())
                    {
                        case '+' :  s1.push(num1+num2);
                                    break;
                        case '-' :  s1.push(num1-num2);
                                    break;
                        case '*' :  s1.push(num1*num2);
                                    break;
                        case '/' :  s1.push(Math.round((num1/num2) * 100)/100.0);
                                    break;
                    }
                    postfix += s.peek();
                    s.pop();
                }
                s.push(content.charAt(i++));
            }
        }
        while(!s.empty())
        {
            try
            {
                num2 = s1.pop();
                num1= s1.pop();
            }
            catch (EmptyStackException e)
            {
                return null;
            }
            switch(s.peek())
            {
                case '+' :  s1.push(num1+num2);
                            break;
                case '-' :  s1.push(num1-num2);
                            break;
                case '*' :  s1.push(num1*num2);
                            break;
                case '/' :  s1.push(Math.round((num1/num2) * 100)/100.0);
                            break;
            }
            postfix += s.peek();
            s.pop();
        }
        try
        {
            Double out = s1.pop();
            if(!s1.empty())
                return null;
            return String.valueOf(out);
        }
        catch(EmptyStackException e)
        {
            return null;
        }
    }
}
