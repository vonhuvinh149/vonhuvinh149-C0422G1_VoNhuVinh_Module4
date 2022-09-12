package dto;

import com.furma.model.customer.CustomerType;
import com.furma.util.CustomerUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "[0-9]{9}")
    private String idCard;

    @NotBlank(message = "vui lòng nhập")
    private String dateOfBirth;

    @NotBlank
    private String gender;

    @NotBlank
    @Pattern(regexp = "((\\+8490)|(\\+8491)|(090)|(091))[0-9]{7}", message = "vui lòng nhập đúng định dạng")
    private String phoneNumber;

    @NotBlank
    @Email(message = "vui lòng nhập đúng định dạng")
    private String email;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "vui lòng nhập đúng định dạng")
    private String address;

    @NotNull
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        CustomerUtil.checkName(customerDto, errors);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
