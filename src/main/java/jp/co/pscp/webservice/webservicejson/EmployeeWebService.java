/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.pscp.webservice.webservicejson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import jp.co.pscp.webservice.model.Employee;
import jp.co.pscp.webservice.model.SalaryDetails;
import jp.co.pscp.webservice.model.SearchParam;

/**
 *
 * @author andysilver
 */
@Path("/empService")
@Stateless
public class EmployeeWebService {

    @GET
    @Path("/noParam")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee() {
        return this.commonMethod();
    }

    @GET
    @Path("/queryParam")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee2(@QueryParam("key1") int year, @QueryParam("empId") String empId) {

        System.out.println(year);
        System.out.println(empId);

        if (year == 0 || empId == null) {
            return null;
        }

        return this.commonMethod();
    }

    @GET
    @Path("/pathParam/{year}/{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee3(@PathParam("year") int year, @PathParam("empId") String empId) {

        System.out.println(year);
        System.out.println(empId);

        if (year == 0 || empId == null) {
            return null;
        }

        return this.commonMethod();
    }

    @POST
    @Path("/formParam")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee4(@FormParam("year") int year, @FormParam("empId") String empId) {

        System.out.println(year);
        System.out.println(empId);

        if (year == 0 || empId == null) {
            return null;
        }

        return this.commonMethod();
    }

    @POST
    @Path("/jsonParam")
    @Consumes(MediaType.APPLICATION_JSON)   //接受JSON格式的参数
    @Produces(MediaType.APPLICATION_JSON)   //返回JSON格式类的数据
    public Employee getEmployee5(SearchParam sp) {

        System.out.println(sp.getEmpId());
        System.out.println(sp.getYear());

        if (sp.getYear() == 0 || sp.getEmpId() == null) {
            return null;
        }

        return this.commonMethod();
    }

    private Employee commonMethod() {
        Employee emp = new Employee();
        emp.setEmpId(100);
        emp.setEmpName("Google");
        emp.setBirthday(Calendar.getInstance().getTime());
        emp.setIsResigned(false);

        List<SalaryDetails> sds = new ArrayList<>();
        SalaryDetails sd1 = new SalaryDetails();
        sd1.setEmpId(100);
        sd1.setYear(2016);
        sd1.setMonth(1);
        sd1.setSalary(new BigDecimal(300000));

        SalaryDetails sd2 = new SalaryDetails();
        sd2.setEmpId(100);
        sd2.setYear(2016);
        sd2.setMonth(2);
        sd2.setSalary(new BigDecimal(350000));

        sds.add(sd1);
        sds.add(sd2);

        emp.setSalarys(sds);

        return emp;
    }
}
