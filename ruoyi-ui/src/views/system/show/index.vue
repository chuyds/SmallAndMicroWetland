<template>
  <div id="index">
    <div id="upload" style="height: 240px;">
<!--      <el-upload
        class="upload-demo"
        action="#"
        :file-list="toUploadFileList"
        drag
        with-credentials
        multiple
        accept=".webp,.jepg,.png,.gif,.jpg,.svg"
        :before-upload="onBeforeUploadOfImage"
        :on-progress="submitFile"
        :auto-upload="true"
        style="margin-top: 10px;display: inline-block;position: absolute;float: left;"
        >
        <h6 style="color: orange;margin-top: 10px;">上传图片</h6>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将图片拖到此处，或<em>点击上传</em></div>
        <el-button size="small" type="success" @click="submitUpload">确认上传</el-button>
        <div class="el-upload__tip" slot="tip">只能上传jpg、jepg、png、gif、svg、webp格式文件，且不超过5MB</div>
      </el-upload> -->

      <div style="width: 100%;margin-top: 10px;display: inline-block;position: absolute;float: left;text-align: center;">
        <h3>上传图片</h3>
        <input type="file" @change="handleFileUpload" accept=".webp,.jepg,.png,.gif,.jpg,.svg">
        <button @click="upload">确认上传</button>
      </div>

<!--     <el-upload
        class="upload-demo"
        drag
        action="/common-upload/file"
        multiple
        accept="video/avi,video/mp4,video/mkv,video/wmv,video/mov,video/flv,video/webm"
        :before-upload="onBeforeUploadOfVideo"
        style="margin-top: 10px;display: inline-block;position: absolute;float: left;"
        >
        <h6 style="color: orange;">上传视频</h6>
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将视频文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">只能上传avi、mp4、mkv、wmv、mov、flv、webm格式视频，且不超过5GB</div>
      </el-upload> -->
    </div>

    <div id="table" style="height: 800px;margin-top: 20px;">
        <el-table
          class="table-demo"
          :data="tableData"
          stripe
          style="width: 45%;position: absolute;float: left;">
          <el-table-column
            prop="date"
            label="上传日期"
            width="120">
          </el-table-column>
          <el-table-column
            prop="name"
            label="图片链接"
            width="220">
          </el-table-column>
          <el-table-column
            label="操作">
            <template slot-scope="scope" v-if="scope.row.roleId !== 1">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:role:edit']"
              >修改</el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:role:remove']"
              >删除</el-button>
              <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)" v-hasPermi="['system:role:edit']">
                <el-button size="mini" type="text" icon="el-icon-d-arrow-right">更多</el-button>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="handleDataScope" icon="el-icon-circle-check"
                    v-hasPermi="['system:role:edit']">数据权限</el-dropdown-item>
                  <el-dropdown-item command="handleAuthUser" icon="el-icon-user"
                    v-hasPermi="['system:role:edit']">分配用户</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </template>
          </el-table-column>
        </el-table>

        <el-table
          class="table-demo"
          :data="tableData"
          stripe
          style="width: 45%;position: absolute;float: left;">
          <el-table-column
            prop="date"
            label="上传日期"
            width="120">
          </el-table-column>
          <el-table-column
            prop="name"
            label="视频链接"
            width="220">
          </el-table-column>
          <el-table-column
            label="操作">
            <template slot-scope="scope" v-if="scope.row.roleId !== 1">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['system:role:edit']"
              >修改</el-button>
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['system:role:remove']"
              >删除</el-button>
              <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)" v-hasPermi="['system:role:edit']">
                <el-button size="mini" type="text" icon="el-icon-d-arrow-right">更多</el-button>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="handleDataScope" icon="el-icon-circle-check"
                    v-hasPermi="['system:role:edit']">数据权限</el-dropdown-item>
                  <el-dropdown-item command="handleAuthUser" icon="el-icon-user"
                    v-hasPermi="['system:role:edit']">分配用户</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </template>
          </el-table-column>
        </el-table>
    </div>

  </div>
</template>

<script>
  import {uploadFile} from "@/api/system/file";
   export default {
      data() {
        return {
          uploadUrl: process.env.VUE_APP_BASE_API + "/common-upload/fileUpload", //action就写成上传文件的接口我这里是动态设置请求地址
          uploadWidth: [],
          tableWidth: [],
          file: null,
          // 原始文件数据
          fileList: {
              type: Array,
              required: true,
              default: () => [],
          },
          // 已上传文件列表
          uploadedFileList: [],
          // 待上传文件列表
          toUploadFileList: [],
          tableData: [{
                    date: '2023-08-31',
                    name: 'https://img2.baidu.com/it/u=127452178,1988177191&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500',
                  }, {
                    date: '2023-08-31',
                    name: 'https://img2.baidu.com/it/u=127452178,1988177191&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500',
                  }, {
                    date: '2023-08-31',
                    name: 'https://img2.baidu.com/it/u=127452178,1988177191&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500',
                  }, {
                    date: '2023-08-31',
                    name: 'https://img2.baidu.com/it/u=127452178,1988177191&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500',
                  }],
          // 遮罩层
          loading: true,
          // 选中数组
          ids: [],
          // 非单个禁用
          single: true,
          // 非多个禁用
          multiple: true,
          // 显示搜索条件
          showSearch: true,
          // 总条数
          total: 0,
          // 角色表格数据
          roleList: [],
          // 弹出层标题
          title: "",
          // 是否显示弹出层
          open: false,
          // 是否显示弹出层（数据权限）
          openDataScope: false,
          menuExpand: false,
          menuNodeAll: false,
          deptExpand: true,
          deptNodeAll: false,
          // 日期范围
          dateRange: [],
          // 数据范围选项
          dataScopeOptions: [
            {
              value: "1",
              label: "全部数据权限"
            },
            {
              value: "2",
              label: "自定数据权限"
            },
            {
              value: "3",
              label: "本部门数据权限"
            },
            {
              value: "4",
              label: "本部门及以下数据权限"
            },
            {
              value: "5",
              label: "仅本人数据权限"
            }
          ],
          // 菜单列表
          menuOptions: [],
          // 部门列表
          deptOptions: [],
          // 查询参数
          queryParams: {
            pageNum: 1,
            pageSize: 10,
            roleName: undefined,
            roleKey: undefined,
            status: undefined
          },
          // 表单参数
          form: {},
          defaultProps: {
            children: "children",
            label: "label"
          },
          // 表单校验
          rules: {
            roleName: [
              { required: true, message: "角色名称不能为空", trigger: "blur" }
            ],
            roleKey: [
              { required: true, message: "权限字符不能为空", trigger: "blur" }
            ],
            roleSort: [
              { required: true, message: "角色顺序不能为空", trigger: "blur" }
            ]
          }
        };
      },
      mounted() {
        this.changeUploadWidth();
        this.changeUploadPosition();

        this.changeTableWidth();
        this.changeTablePosition();
      },

      methods: {
        handleFileUpload(event) {
              this.file = event.target.files[0];
        },
        upload() {
          const formData = new FormData();
          formData.append('file', this.file);

          uploadFile(formData).then(response=>{
            alert(response);
          });
        },
        /**
         * 文件上传
         */
        fileUploadInner() {
            let formData = new FormData();
            this.toUploadFileList.forEach((item) => {
                formData.append('file', item.raw);
            });
            $http({
                url: this.uploadUrl,
                method: 'post',
                data: formData,
                headers: { 'Content-Type': 'multipart/form-data' },
            })
                .then(({ data }) => {
                    // 1、更新已上传文件列表
                    this.uploadedFileList = this.uploadedFileList.concat(data);
                    // 2、更新待上传文件列表
                    let returnFileMap = new Map(data.map((value) => [value.fileName, value.fileId]));
                    this.toUploadFileList = this.toUploadFileList
                        .filter((item) => !returnFileMap.has(item.name))
                        .map((item) => {
                            item.status = 'error';
                            return item;
                        });
                    this.$message.success('附件上传完成');
                })
                .catch((e) => {
                    this.$message.error(e.message || '附件上传失败');
                });
        },
        // 获取上传框宽度
        changeUploadWidth() {
          var uploadElt = document.getElementsByClassName('upload-demo');
          for (var i = 0; i < uploadElt.length; i++) {
            this.uploadWidth.push(uploadElt[i].clientWidth);
          }
        },
        // 改变上传框位置(居中)
        changeUploadPosition() {
          var documentWidth = document.body.clientWidth - 200;
          var uploadElt = document.getElementsByClassName('upload-demo');
          for (var i = 0; i < uploadElt.length; i++) {
            // alert('documentWidth:'+documentWidth+'  uploadElt.length:'+uploadElt.length+'  this.uploadWidth[i]:'+this.uploadWidth[i]);
            uploadElt[i].style.marginLeft = documentWidth/uploadElt.length*i + documentWidth/uploadElt.length/2 - this.uploadWidth[i]/2 + 'px';
          }
        },
        // 获取表格宽度
        changeTableWidth() {
          var tableElt = document.getElementsByClassName('table-demo');
          for (var i = 0; i < tableElt.length; i++) {
            this.tableWidth.push(tableElt[i].clientWidth);
          }
        },
        // 改变表格位置(居中)
        changeTablePosition() {
          var documentWidth = document.body.clientWidth - 200;
          var uploadElt = document.getElementsByClassName('upload-demo');
          var tableElt = document.getElementsByClassName('table-demo');
          for (var i = 0; i < tableElt.length; i++) {
            // alert('documentWidth:'+documentWidth+'  tableElt.length:'+tableElt.length+'  this.tableWidth[i]:'+this.tableWidth[i]);
            tableElt[i].style.marginLeft = documentWidth/tableElt.length*i + documentWidth/tableElt.length/2 - this.tableWidth[i]/2 + 'px';
            // tableElt[i].style.marginTop = uploadElt[i].clientHeight + 60 + 'px';
          }
        },
        // 图片上传之前,检验
        onBeforeUploadOfImage(file) {
          const isIMAGE = (file.type === '.jpeg'||'.gif'||'.png'||'.jpg'||'.svg'||'.webp');
          const isLt5M = file.size / 1024 / 1024 < 5;
          if (!isIMAGE) {
            this.$message.error('上传的文件格式错误!');
          }
          if (!isLt5M) {
            this.$message.error('上传图片大小不能超过 5MB!');
          }
          return isIMAGE && isLt5M;
        },
        submitFile(event){
          debugger;
          if(this.onBeforeUploadOfImage){
            let file = event.target.files[0];
            let formData = new FormData();
            formData.append('file',file);
            debugger;
            uploadFile(formData).then(({ data }) => {
                    // 1、更新已上传文件列表
                    this.uploadedFileList = this.uploadedFileList.concat(data);
                    // 2、更新待上传文件列表
                    let returnFileMap = new Map(data.map((value) => [value.fileName, value.fileId]));
                    this.toUploadFileList = this.toUploadFileList
                        .filter((item) => !returnFileMap.has(item.name))
                        .map((item) => {
                            item.status = 'error';
                            return item;
                        });
                    this.$message.success('附件上传完成');
                })
                .catch((e) => {
                    this.$message.error(e.message || '附件上传失败');
                });
          }
        },
        // 视频上传之前,检验
        onBeforeUploadOfVideo(file) {
          const isIMAGE = file.type === 'video/avi'||'video/mp4'||'video/mkv'||'video/wmv'||'video/mov'||'video/flv'||'video/webm';
          const isLt5M = file.size / 1024 / 1024 / 1024 < 5;

          if (!isIMAGE) {
            this.$message.error('上传的文件格式错误!');
          }
          if (!isLt5M) {
            this.$message.error('上传视频大小不能超过 5GB!');
          }
          return isIMAGE && isLt5M;
        },
        /** 查询角色列表 */
        getList() {
          this.loading = true;
          listRole(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
              this.roleList = response.rows;
              this.total = response.total;
              this.loading = false;
            }
          );
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
          this.reset();
          const roleId = row.roleId || this.ids
          const roleMenu = this.getRoleMenuTreeselect(roleId);
          getRole(roleId).then(response => {
            this.form = response.data;
            this.open = true;
            this.$nextTick(() => {
              roleMenu.then(res => {
                let checkedKeys = res.checkedKeys
                checkedKeys.forEach((v) => {
                    this.$nextTick(()=>{
                        this.$refs.menu.setChecked(v, true ,false);
                    })
                })
              });
            });
            this.title = "修改角色";
          });
        },
        /** 删除按钮操作 */
        handleDelete(row) {
          const roleIds = row.roleId || this.ids;
          this.$modal.confirm('是否确认删除数据项？').then(function() {
            return delRole(roleIds);
          }).then(() => {
            this.getList();
            this.$modal.msgSuccess("删除成功");
          }).catch(() => {});
        },
        // 更多操作触发
        handleCommand(command, row) {
          switch (command) {
            case "handleDataScope":
              this.handleDataScope(row);
              break;
            case "handleAuthUser":
              this.handleAuthUser(row);
              break;
            default:
              break;
          }
        },
      }
    }
</script>

<style>
</style>
