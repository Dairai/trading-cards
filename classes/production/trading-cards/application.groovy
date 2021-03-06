

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.cards.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.cards.UserRole'
grails.plugin.springsecurity.authority.className = 'com.cards.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/credits',        access: ['permitAll']],
	[pattern: '/howtouse',       access: ['permitAll']],
	[pattern: '/about',          access: ['permitAll']],
	[pattern: '/membership',     access: ['permitAll']],
	[pattern: '/siterules',      access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/searchType.gsp', access: ['permitAll']],
	[pattern: '/userProfile.gsp',access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

