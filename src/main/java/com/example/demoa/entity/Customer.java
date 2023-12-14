package com.example.demoa.entity;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerEmail;
    private String customerName;
    private String customerPassword;
//    private Role customerRole;



//    iuoiu oiuoiuoiuoiuoi uoi oiuoiu oi oi uoi uohjmu h fnjfh j fh g gh g g ddtdtj  jj fgtjfgjlk;l k;  sdsds frf gtfhd gcj gj io jlk lkh lkjh
//    oi uiooip oiupkjljlk lkjii ojlk j kjkljfghdfghdfghdfghdfghghdfghdfghfcghjbnvg l kjh kjhk kkldjlkjs lkjlkjf lkjsljwoiepwip lksjdlk powipoidlkjlksjlkrtgwtgtop ipoipipi po
//    kjlkjlkjl kjlkj lkj lkjlk klj lllkjl lkjl lkjlkjl khkhkjhlkjhlkjhl uhhoihoiu o oi ofkjlksjlfd lkfjd lkjdlkjlf kjdlkjfldkj dlkdjlkjd lkdjlkjflkdjflkjlkdjflkdjflk jdlkjld jlk lkj lkjj lk jlkj lj lkj lkj lk jlk jlkj lknbmbmnbmn jlk jlkj lkj lkk jlj lkj ljlk jl jlk jlk jlk jlkj lk jlkj l jlkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj lkj liu oiuoiujlkjlk oiuoiuokjjljoiuuoi jlkjlk jiouoiu lkjlkj oiuoiu lkjlkj oi u oiu ojlkjlkj oiuoiu oijkljlkjoiu oiuojilkjlkjl oiuoiu olkj lkj lkuoiuoiuoiljkjlkj oiuoiuojlkjlkkkkkmmmmkkm,m,m,mlklkllklllllklklkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkklkkllkllllllllllllllklkllllkllllkkkllllllkllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllklllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllkmlmllmlmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmlkmlmlmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmlklkmlmlkmlkmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmlkmlllllllllllllllllllkmlllllmllkmlkmlkmlkmlkmlmlmkmllmlklkmlmlmlmllmmlmlmmmmmmmkmllllllllllllllmlmlmmmmmmmmmmmmmlkklkkmlmllmlmlmlmmlmlkmlmlkmlmlmlmllmllmlmlmllmlmlkmlmkmkllllllkkkkkkkkklmlmlllllllllllllllllmlmlmmllmlkmlllllmlkmmlmlmlmkmlkmlmlkmlkmlkmlkmlkoopoooopolklklklk
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

//    public Role getCustomerRole() {
//        return customerRole;
//    }
//
//    public void setCustomerRole(Role customerRole) {
//        this.customerRole = customerRole;
//    }
}
