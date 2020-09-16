package com.workorder.app.workorderapplication.model.assetModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EquipmentCategory {
        @SerializedName("categoryName")
        @Expose
        private String categoryName;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("parentCategoryId")
        @Expose
        private Integer parentCategoryId;
        @SerializedName("parentCategory")
        @Expose
        private Object parentCategory;
        @SerializedName("escalationLevel")
        @Expose
        private Integer escalationLevel;
        @SerializedName("warningLevel")
        @Expose
        private Integer warningLevel;
        @SerializedName("entityText")
        @Expose
        private String entityText;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("entityStatus")
        @Expose
        private Integer entityStatus;
        @SerializedName("createdDate")
        @Expose
        private String createdDate;
        @SerializedName("createdBy")
        @Expose
        private Integer createdBy;
        @SerializedName("updatedDate")
        @Expose
        private Object updatedDate;
        @SerializedName("updatedBy")
        @Expose
        private Object updatedBy;
        @SerializedName("deletedDate")
        @Expose
        private String deletedDate;
        @SerializedName("deletedBy")
        @Expose
        private Integer deletedBy;
        @SerializedName("isDeleted")
        @Expose
        private Boolean isDeleted;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getParentCategoryId() {
            return parentCategoryId;
        }

        public void setParentCategoryId(Integer parentCategoryId) {
            this.parentCategoryId = parentCategoryId;
        }

        public Object getParentCategory() {
            return parentCategory;
        }

        public void setParentCategory(Object parentCategory) {
            this.parentCategory = parentCategory;
        }

        public Integer getEscalationLevel() {
            return escalationLevel;
        }

        public void setEscalationLevel(Integer escalationLevel) {
            this.escalationLevel = escalationLevel;
        }

        public Integer getWarningLevel() {
            return warningLevel;
        }

        public void setWarningLevel(Integer warningLevel) {
            this.warningLevel = warningLevel;
        }

        public String getEntityText() {
            return entityText;
        }

        public void setEntityText(String entityText) {
            this.entityText = entityText;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getEntityStatus() {
            return entityStatus;
        }

        public void setEntityStatus(Integer entityStatus) {
            this.entityStatus = entityStatus;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public Object getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(Object updatedDate) {
            this.updatedDate = updatedDate;
        }

        public Object getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Object updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getDeletedDate() {
            return deletedDate;
        }

        public void setDeletedDate(String deletedDate) {
            this.deletedDate = deletedDate;
        }

        public Integer getDeletedBy() {
            return deletedBy;
        }

        public void setDeletedBy(Integer deletedBy) {
            this.deletedBy = deletedBy;
        }

        public Boolean getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

    }
