package network.y9.logger.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName(LoggerInfoEntity.TABLE_NAME)
@ApiModel("日志信息")
public class LoggerInfoEntity {

    public static final String TABLE_NAME = "logger_info";

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("访问的url")
    @TableField("url")
    private String url;

    @ApiModelProperty("类名")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("方法名")
    @TableField("method_name")
    private String methodName;

    @ApiModelProperty("请求的ip地址")
    @TableField("req_ip_adr")
    private String reqIpAdr;

    @ApiModelProperty("响应的ip地址（集群提供）")
    @TableField("rsp_ip_adr")
    private String rspIpAdr;

    @ApiModelProperty("成功标志")
    @TableField("success_ind")
    private Boolean successInd;

    @ApiModelProperty("请求报文头")
    @TableField("req_header")
    private String reqHeader;

    @ApiModelProperty("请求报文体")
    @TableField("req_body")
    private String reqBody;

    @ApiModelProperty("响应报文体")
    @TableField("rsp_body")
    private String rspBody;

    @ApiModelProperty("错误信息")
    @TableField("error_msg")
    private String errorMsg;

    @ApiModelProperty("总耗时")
    @TableField("total_time")
    private Long totalTime;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;
}
