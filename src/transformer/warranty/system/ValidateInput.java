/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transformer.warranty.system;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jatin
 */
public class ValidateInput {
    public boolean datecheck(String d, String m, String y){
        int day = Integer.parseInt(d);
       int month = Integer.parseInt(m);
       int year = Integer.parseInt(y); 
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date today = c.getTime();
            
        long todayInMillis = c.getTimeInMillis();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        Date dateSpecified = c.getTime();
        try{
       
       if(month>=1 && month<=12){ 
       if((year%4)==0){
           
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            {
              try{
                  if(day>=1&&day<=31){
                      if(dateSpecified.before(today)){
            JOptionPane.showMessageDialog(null, " past " + dateSpecified);
            return false;
        }
        else{
            if(dateSpecified.after(today)){
                JOptionPane.showMessageDialog(null, "Date is from the future " + dateSpecified);
                return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Date is todays date " + dateSpecified);
            return true;
            }
        }
                  }
                  else
                      JOptionPane.showMessageDialog(null, "Failed");
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
            }
            else{
                if(month==2)
                {
                   try{
                  if(day>=1&&day<=29){
                      if(dateSpecified.before(today)){
            JOptionPane.showMessageDialog(null, " past " + dateSpecified);
            return false;
        }
        else{
            if(dateSpecified.after(today)){
                JOptionPane.showMessageDialog(null, "Date is from the future " + dateSpecified);
                return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Date is todays date " + dateSpecified);
                return true;
            }
        }
                  }
                  else
                  JOptionPane.showMessageDialog(null, "Failed");
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
                }
                else{
                {
                     try{
                  if(day>=1&&day<=30){
                      if(dateSpecified.before(today)){
            JOptionPane.showMessageDialog(null, " past " + dateSpecified);
            return false;
        }
        else{
            if(dateSpecified.after(today)){
                JOptionPane.showMessageDialog(null, "Date is from the future " + dateSpecified);
                return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Date is todays date " + dateSpecified);
                return true;
            }
        }
                  }
                  else
                  JOptionPane.showMessageDialog(null, "Failed");
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
                }
                    }}
        }
        else{
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            {
                 try{
                  if(day>=1&&day<=31){
                      if(dateSpecified.before(today)){
            JOptionPane.showMessageDialog(null, " past " + dateSpecified);
            return false;
        }
        else{
            if(dateSpecified.after(today)){
                JOptionPane.showMessageDialog(null, "Date is from the future " + dateSpecified);
            return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Date is todays date " + dateSpecified);
            return true;
            }
        }
                  }
                      else
                  JOptionPane.showMessageDialog(null, "Failed");
                 
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
            }
            else{
                if(month==2){
                     try{
                  if(day>=1&&day<=28){
                      if(dateSpecified.before(today)){
            JOptionPane.showMessageDialog(null, " past " + dateSpecified);
        return false;
                      }
        else{
            if(dateSpecified.after(today)){
                JOptionPane.showMessageDialog(null, "Date is from the future " + dateSpecified);
            return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Date is todays date " + dateSpecified);
            return true;
            }
        }
                  }
                     else
                  JOptionPane.showMessageDialog(null, "Failed");
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
                }
                else{
                     try{
                  if(day>=1&&day<=30){
                     if(dateSpecified.before(today)){
            JOptionPane.showMessageDialog(null, " past " + dateSpecified);
        return false;
                     }
        else{
            if(dateSpecified.after(today)){
                JOptionPane.showMessageDialog(null, "Date is from the future " + dateSpecified);
            return false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Date is todays date " + dateSpecified);
            return true;
            }
        }
                  }
                    else
                  JOptionPane.showMessageDialog(null, "Failed");
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
                }
            }
        }}
           else
          {
                   JOptionPane.showMessageDialog(null,"Invalid Month");
                   return false;
                   }}
    catch(NumberFormatException  e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Input");
            return false;
        }
  return true;
    }
    public boolean datecheck2(String d, String m, String y){
        int day = Integer.parseInt(d);
       int month = Integer.parseInt(m);
       int year = Integer.parseInt(y); 
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date today = c.getTime();
            
        long todayInMillis = c.getTimeInMillis();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month-1);
        c.set(Calendar.DAY_OF_MONTH, day);
        Date dateSpecified = c.getTime();
        try{
       
       if(month>=1 && month<=12){ 
       if((year%4)==0){
           
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            {
              try{
                  if(day>=1&&day<=31){
                    return true;
                  }
                  else
                      JOptionPane.showMessageDialog(null, "Failed");
              return false;
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
            }
            else{
                if(month==2)
                {
                   try{
                  if(day>=1&&day<=29){
           return true;
                  }
                  else
                  JOptionPane.showMessageDialog(null, "Failed");
              return false;
                   }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
                }
                else{
                {
                     try{
                  if(day>=1&&day<=30){
                      return true;
                  }
                  else
                  JOptionPane.showMessageDialog(null, "Failed");
           return false;
                     }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              }
                }
                    }}
        }
        else{
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            {
                 try{
                  if(day>=1&&day<=31){
                     return true;
                  }
                      else
                  JOptionPane.showMessageDialog(null, "Failed");
               return false;  
              }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              return false;
              }
            }
            else{
                if(month==2){
                     try{
                  if(day>=1&&day<=28){
                      return true;
                  }
                     else
                  JOptionPane.showMessageDialog(null, "Failed");
             return false;
                     }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
              return false;
              }
                }
                else{
                     try{
                  if(day>=1&&day<=30){
                     return true;
                  }
                    else
                 JOptionPane.showMessageDialog(null, "Failed");
              return false;
                     }
              catch(IllegalArgumentException e){
                 JOptionPane.showMessageDialog(null, e);
                 return false;
              }
                }
            }
        }}
           else
          {
                   JOptionPane.showMessageDialog(null,"Invalid Month");
                   return false;
                   }}
    catch(NumberFormatException  e)
        {
            JOptionPane.showMessageDialog(null, "Invalid Input");
            return false;
        }
        return true;
    }
}