<template>
  <button :disabled="isDisabled">Submit</button>
</template>



<script>
  import { useIsFormDirty, useIsFormValid } from "vee-validate";
  import { computed } from "vue";

  export default {
    name: "SubmitButton",
    data() {
      isDirty,
      isValid,
      isDisabled
    }

  }

  const isDirty = useIsFormDirty();
  const isValid = useIsFormValid();
  
  // button only gets enabled if the form is valid *and* has changed (is dirty)
  const isDisabled = computed(() => {
    return !isDirty.value || !isValid.value;
  })

</script>
