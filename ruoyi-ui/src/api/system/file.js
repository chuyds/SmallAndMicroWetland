import request from '@/utils/request'


export function uploadFile(file) {
  return request({
      url: '/common-upload/fileUpload',
      method: 'post',
      headers: { 'Content-Type': 'multipart/form-data' },
      data:file
  })
}
