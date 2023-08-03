<template>
    <tr>
        <td class="brewery-name">{{ brewery.name }}</td>
        <td class="brewery-address">{{ brewery.address }}</td>
        <td class="brewery-city">{{ brewery.city }}</td>
        <td class="brewery-zip">{{ brewery.zip }}</td>
        <td class="brewery-phone">{{ brewery.phone }}</td>
        <td class="brewery-lat-long">{{ brewery.latitude }}, {{ brewery.longitude }}</td>
        <td class="brewery-website">{{ brewery.website }}</td>
    </tr>
</template>

<script>
export default {
    name: 'brewery-card',
    props: {
        brewery: {
            type: Object,
            required: true
        }
    }
}
</script>