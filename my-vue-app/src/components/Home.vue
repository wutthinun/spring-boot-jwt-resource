<template>
  Hello : {{ user?.title }} {{ user?.firstName }} {{ user?.lastName }}
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {useRouter} from 'vue-router';

const user = ref(null)
const router = useRouter()
const BASE_URL = import.meta.env.VITE_API_BASE_URL

const loadUser = async () => {
  const res = await fetch(`${BASE_URL}/me`, {
    headers: {
      'authorization': `bearer ${localStorage.getItem('token')}`
    }
  })

  if (res.status === 401)
    router.push('/login')

  if (res.ok) {
    user.value = await res.json();
  }
}

onMounted(() => {
  const token = localStorage.getItem('token')
  if (!token) {
    router.push('/login')
  }

  loadUser()
})
</script>

<style scoped>

</style>
