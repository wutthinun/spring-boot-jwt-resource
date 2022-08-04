<template>
  <div class="container h-100">
    <div class="row d-md-flex justify-content-center align-items-center h-50">
      <div class="col-12 col-md-4 bg-white p-3 rounded">
        <form @submit="onSubmit">
          <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username"
                   name="username"
                   autocomplete="off"
                   :value="username"
                   @input="event => username = event.target.value"
            >
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password"
                   name="password"
                   :value="password"
                   @input="event => password = event.target.value"
            >
          </div>

          <div class="text-end">
            <button type="button" class="btn btn-primary"
                    @click="onSubmit"
            >Sign In</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script setup>

import {ref} from 'vue';
import {useRouter} from 'vue-router';

const BASE_URL = import.meta.env.VITE_API_BASE_URL

const username = ref(null)
const password = ref(null)
const router = useRouter()

const onSubmit = async () => {
  const response = await fetch(`${BASE_URL}/public/login`, {
    method: 'POST',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify({
      username: username.value,
      password: password.value
    })
  })

  const {token} = await response.json()
  localStorage.setItem('token', token)
  router.push('/')
}

</script>

<style scoped>

</style>
