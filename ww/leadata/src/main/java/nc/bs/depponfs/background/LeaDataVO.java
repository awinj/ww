package nc.bs.depponfs.background;

import java.math.BigDecimal;

/**
 * Created by aWin on 2018-07-19.
 */
public class LeaDataVO {
    private String pk;
    private BigDecimal primonthdeduct;   //上月工资不够扣
    private BigDecimal personnelfee;//groupdef23;   //人事代理费
    private BigDecimal familyded;   //代付亲情1+1
    private BigDecimal feeded;   //代付话费
    private BigDecimal socialded;   //代扣个人社保
    private BigDecimal housingded;   //代扣住房公积金
    private BigDecimal repayded;   //代还个人借款
    private BigDecimal stayded;   //住宿扣款
    private BigDecimal partydues;   //党费扣款
    private BigDecimal acccardmny;   //公积金卡扣款
    private BigDecimal otherded;   //其他扣款
    private BigDecimal surpluswages;//groupdef12;   //剩余工资
    private BigDecimal emphandbookmny;   //员工手册扣款
    private BigDecimal carded;   //商务车扣款
    private BigDecimal totalreward;   //奖励小计
    private String psnname;//pk_psndoc;   // 参照类型      姓名
    private String jobcode;//pk_om_job;   // 岗位编码
    private String jobname;//pk_om_job;   // 岗位名称
    private String jobtype;             //岗位类别
    private BigDecimal industrialinjury;   //工伤扣款
    private String psncode;   // 工号
    private BigDecimal workclothesmny;   //工服扣款
    private BigDecimal workcardmny;   //工牌扣款
    private BigDecimal salaryzk;   //工资暂扣
    private BigDecimal balancead;   //差额调整
    private String deptcode;//pk_deptdoc;   // 所属部门
    private String deptname;//pk_deptdoc;   // 所属部门
    private BigDecimal totalded;   //扣款小计
    private String yearmonth;//pk_lea_planperiod;   // 参照类型      期间
    private BigDecimal taxded;   //本次代扣税
    private String socialunit;   // 社保主体单位
    private BigDecimal debded;   //绩效罚款
    private BigDecimal compensaded;   //赔偿损失
    private BigDecimal discided;   //违纪罚款
    private BigDecimal socialsecuritycardmny; //  社保卡扣款
    private String deptstncode;//部门标准编码（部门标杆编码）

    private String istrainee;


    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public BigDecimal getPrimonthdeduct() {
        return primonthdeduct;
    }

    public void setPrimonthdeduct(BigDecimal primonthdeduct) {
        this.primonthdeduct = primonthdeduct;
    }

    public BigDecimal getPersonnelfee() {
        return personnelfee;
    }

    public void setPersonnelfee(BigDecimal personnelfee) {
        this.personnelfee = personnelfee;
    }

    public BigDecimal getFamilyded() {
        return familyded;
    }

    public void setFamilyded(BigDecimal familyded) {
        this.familyded = familyded;
    }

    public BigDecimal getFeeded() {
        return feeded;
    }

    public void setFeeded(BigDecimal feeded) {
        this.feeded = feeded;
    }

    public BigDecimal getSocialded() {
        return socialded;
    }

    public void setSocialded(BigDecimal socialded) {
        this.socialded = socialded;
    }

    public BigDecimal getHousingded() {
        return housingded;
    }

    public void setHousingded(BigDecimal housingded) {
        this.housingded = housingded;
    }

    public BigDecimal getRepayded() {
        return repayded;
    }

    public void setRepayded(BigDecimal repayded) {
        this.repayded = repayded;
    }

    public BigDecimal getStayded() {
        return stayded;
    }

    public void setStayded(BigDecimal stayded) {
        this.stayded = stayded;
    }

    public BigDecimal getPartydues() {
        return partydues;
    }

    public void setPartydues(BigDecimal partydues) {
        this.partydues = partydues;
    }

    public BigDecimal getAcccardmny() {
        return acccardmny;
    }

    public void setAcccardmny(BigDecimal acccardmny) {
        this.acccardmny = acccardmny;
    }

    public BigDecimal getOtherded() {
        return otherded;
    }

    public void setOtherded(BigDecimal otherded) {
        this.otherded = otherded;
    }

    public BigDecimal getSurpluswages() {
        return surpluswages;
    }

    public void setSurpluswages(BigDecimal surpluswages) {
        this.surpluswages = surpluswages;
    }

    public BigDecimal getEmphandbookmny() {
        return emphandbookmny;
    }

    public void setEmphandbookmny(BigDecimal emphandbookmny) {
        this.emphandbookmny = emphandbookmny;
    }

    public BigDecimal getCarded() {
        return carded;
    }

    public void setCarded(BigDecimal carded) {
        this.carded = carded;
    }

    public BigDecimal getTotalreward() {
        return totalreward;
    }

    public void setTotalreward(BigDecimal totalreward) {
        this.totalreward = totalreward;
    }

    public String getPsnname() {
        return psnname;
    }

    public void setPsnname(String psnname) {
        this.psnname = psnname;
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public BigDecimal getIndustrialinjury() {
        return industrialinjury;
    }

    public void setIndustrialinjury(BigDecimal industrialinjury) {
        this.industrialinjury = industrialinjury;
    }

    public String getPsncode() {
        return psncode;
    }

    public void setPsncode(String psncode) {
        this.psncode = psncode;
    }

    public BigDecimal getWorkclothesmny() {
        return workclothesmny;
    }

    public void setWorkclothesmny(BigDecimal workclothesmny) {
        this.workclothesmny = workclothesmny;
    }

    public BigDecimal getWorkcardmny() {
        return workcardmny;
    }

    public void setWorkcardmny(BigDecimal workcardmny) {
        this.workcardmny = workcardmny;
    }

    public BigDecimal getSalaryzk() {
        return salaryzk;
    }

    public void setSalaryzk(BigDecimal salaryzk) {
        this.salaryzk = salaryzk;
    }

    public BigDecimal getBalancead() {
        return balancead;
    }

    public void setBalancead(BigDecimal balancead) {
        this.balancead = balancead;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public BigDecimal getTotalded() {
        return totalded;
    }

    public void setTotalded(BigDecimal totalded) {
        this.totalded = totalded;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public BigDecimal getTaxded() {
        return taxded;
    }

    public void setTaxded(BigDecimal taxded) {
        this.taxded = taxded;
    }

    public String getSocialunit() {
        return socialunit;
    }

    public void setSocialunit(String socialunit) {
        this.socialunit = socialunit;
    }

    public BigDecimal getDebded() {
        return debded;
    }

    public void setDebded(BigDecimal debded) {
        this.debded = debded;
    }

    public BigDecimal getCompensaded() {
        return compensaded;
    }

    public void setCompensaded(BigDecimal compensaded) {
        this.compensaded = compensaded;
    }

    public BigDecimal getDiscided() {
        return discided;
    }

    public void setDiscided(BigDecimal discided) {
        this.discided = discided;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public BigDecimal getSocialsecuritycardmny() {
        return socialsecuritycardmny;
    }

    public void setSocialsecuritycardmny(BigDecimal socialsecuritycardmny) {
        this.socialsecuritycardmny = socialsecuritycardmny;
    }

    public String getDeptstncode() {
        return deptstncode;
    }

    public void setDeptstncode(String deptstncode) {
        this.deptstncode = deptstncode;
    }

    public String getIstrainee() {
        return istrainee;
    }

    public void setIstrainee(String istrainee) {
        this.istrainee = istrainee;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
