import java.util.*;

class employee
{
int empid;
long mobile;
String name, address, mailid;
Scanner get = new Scanner(System.in);

void getdata()
{
System.out.println("Enter Name of the Employee");
name = get.nextLine();
System.out.println("Enter Mail id");
mailid = get.nextLine();
System.out.println("Enter Address of the Employee:");
address = get.nextLine();
System.out.println("Enter employee id ");
empid = get.nextInt();
System.out.println("Enter Mobile Number");
mobile = get.nextLong();
}

void display()
{
    System.out.println("Name of the employee is:- "+name);
    System.out.println("Employee id:- "+empid);
    System.out.println("Email address of the employee is:- "+mailid);
    System.out.println("Employee's current address is:- "+address);
    System.out.println("Mobile Number of the employee is:- "+mobile);
}
}

class Programmer extends employee
{
    double salary,bp,da,hra,pf,club,net,gross;

    void getprogrammer()
    {
        System.out.println("Enter basic pay");
        bp = get.nextDouble();
    }

    void calculateprog()
    {
        da=(0.97*bp);
        hra=(0.10*bp);
        pf=(0.12*bp);
        club=(0.1*bp);
        gross=(bp+da+hra);
        net=(gross-pf-club);
        System.out.println("************************************************");
        System.out.println("PAY SLIP FOR PROGRAMMER");
        System.out.println("************************************************");
        System.out.println("Basic Pay:Rs"+bp);
        System.out.println("DA:Rs"+da);
        System.out.println("PF:Rs"+pf);
        System.out.println("HRA:Rs"+hra);
        System.out.println("CLUB:Rs"+club);
        System.out.println("GROSS PAY:Rs"+gross);
        System.out.println("NET PAY:Rs"+net);
    }

}

class TeamLead extends employee
{
    double salary,bp,da,hra,pf,club,net,gross;
    
    void getlead()
    {
        System.out.println("Enter basic pay");
        bp = get.nextDouble();
    }
    
    void calculatelead()
    {
        da=(0.97*bp);
        hra=(0.10*bp);
        pf=(0.12*bp);
        club=(0.1*bp);
        gross=(bp+da+hra);
        net=(gross-pf-club);
        System.out.println("************************************************");
        System.out.println("PAY SLIP FOR TEAM LEAD");
        System.out.println("************************************************");
        System.out.println("Basic Pay:Rs"+bp);
        System.out.println("DA:Rs"+da);
        System.out.println("HRA:Rs"+hra);
        System.out.println("PF:Rs"+pf);
        System.out.println("CLUB:Rs"+club);
        System.out.println("GROSS PAY:Rs"+gross);
        System.out.println("NET PAY:Rs"+net);
    }
}

class AssistantProjectManager extends employee
{
    double salary,bp,da,hra,pf,club,net,gross;
    
    void getassistant()
    {
        System.out.println("Enter basic pay");
        bp = get.nextDouble();
    }
    
    void calculateassistant()
    {
        da=(0.97*bp);
        hra=(0.10*bp);
        pf=(0.12*bp);
        club=(0.1*bp);
        gross=(bp+da+hra);
        net=(gross-pf-club);
        System.out.println("************************************************");
        System.out.println("PAY SLIP FOR ASSISTANT PROJECT MANAGER");
        System.out.println("************************************************");
        System.out.println("Basic Pay:Rs"+bp);
        System.out.println("DA:Rs"+da);
        System.out.println("HRA:Rs"+hra);
        System.out.println("PF:Rs"+pf);
        System.out.println("CLUB:Rs"+club);
        System.out.println("GROSS PAY:Rs"+gross);
        System.out.println("NET PAY:Rs"+net);
    }
}

class ProjectManager extends employee
{
    double salary,bp,da,hra,pf,club,net,gross;

    void getprojectmanager()
    {
        System.out.println("Enter basic pay");
        bp = get.nextDouble();
    }
    
    void calculateprojectmanager()
    {
        da=(0.97*bp);
        hra=(0.10*bp);
        pf=(0.12*bp);
        club=(0.1*bp);
        gross=(bp+da+hra);
        net=(gross-pf-club);
        System.out.println("************************************************");
        System.out.println("PAY SLIP FOR PROJECT MANAGER");
        System.out.println("************************************************");
        System.out.println("Basic Pay:Rs"+bp);
        System.out.println("DA:Rs"+da);
        System.out.println("HRA:Rs"+hra);
        System.out.println("PF:Rs"+pf);
        System.out.println("CLUB:Rs"+club);
        System.out.println("GROSS PAY:Rs"+gross);
        System.out.println("NET PAY:Rs"+net);
    }
}

class salary
{
    public static void main(String args[])
    {
        int choice,cont;
        do
        {
            System.out.println("PAYROLL");
            System.out.println(" 1.PROGRAMMER \t 2.TEAM LEAD \t 3.ASSISTANT PROJECT MANAGER \t 4.PROJECT MANAGER ");
            Scanner c = new Scanner(System.in);
            choice=c.nextInt();
            switch(choice)
            {
                case 1:
                {
                    Programmer p=new Programmer();
                    p.getdata();
                    p.getprogrammer();
                    p.display();
                    p.calculateprog();
                    break;
                }
                case 2:
                {
                    TeamLead asst=new TeamLead();
                    asst.getdata();
                    asst.getlead();
                    asst.display();
                    asst.calculatelead();
                    break;
                }
                case 3:
                {
                    AssistantProjectManager asso=new AssistantProjectManager();
                    asso.getdata();
                    asso.getassistant();
                    asso.display();
                    asso.calculateassistant();
                    break;
                }
                case 4:
                {
                    ProjectManager prof=new ProjectManager();
                    prof.getdata();
                    prof.getprojectmanager();
                    prof.display();
                    prof.calculateprojectmanager();
                    break;
                }
            }c.close();
            System.out.println("Do u want to continue 0 to quit and  1 to continue ");
            cont=c.nextInt();
        }while(cont==1);
    }
}
