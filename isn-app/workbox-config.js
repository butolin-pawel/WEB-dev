module.exports = {
	globDirectory: 'public/',
	globPatterns: [
		'**/*.{ico,jpg,html,json}'
	],
	swDest: 'public/sw.js',
	ignoreURLParametersMatching: [
		/^utm_/,
		/^fbclid$/
	]
};